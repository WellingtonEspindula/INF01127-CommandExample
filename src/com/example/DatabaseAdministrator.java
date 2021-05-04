package com.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DatabaseAdministrator implements Runnable {

    private boolean isRunning;
    private boolean currentCommandIsFinished;

    private List<DbCommand> history;
    private Queue<DbCommand> operationsQueue;

    private final DbCommandStateChangedReceiver dbCommandStateChangedReceiver = newState -> {
        if (newState == DbCommandState.FINISHED){
            finishedCurrentCommand();
        }
    };

    public DatabaseAdministrator() {
        isRunning = false;
        history = new ArrayList<>();
        operationsQueue = new LinkedList<>();
        currentCommandIsFinished = false;
    }

    public void start() {
        isRunning = true;
        Thread newThread = new Thread(this);
        newThread.start();

    }

    public void stop() {
        isRunning = false;
    }

    private void finishedCurrentCommand() {
        currentCommandIsFinished = true;
    }

    public void enqueue(DbCommand command){
        command.setReceiver(dbCommandStateChangedReceiver);
        operationsQueue.add(command);
    }

    public List<DbCommand> getHistory(){
        return history;
    }

    @Override
    public void run() {
        while (isRunning) {
            if (!operationsQueue.isEmpty()) {
                DbCommand command = operationsQueue.element();
                command.execute();

                while (!currentCommandIsFinished) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                currentCommandIsFinished = false;
                operationsQueue.remove();
                history.add(command);

            } else {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
