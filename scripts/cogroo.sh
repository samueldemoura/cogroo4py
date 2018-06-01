#!/usr/bin/env bash
SERVICE_NAME=cogroo4py
PATH_TO_JAR=cogroo4py.jar
PID_PATH_NAME=/tmp/cogroo4py.pid
ERROR_LOG_FILE=cogroo4py.err
LOG_FILE=cogroo4py.log

case $1 in
    start)
        echo "Starting $SERVICE_NAME ..."
        if [ ! -f $PID_PATH_NAME ]; then
            nohup java -jar $PATH_TO_JAR /tmp 2>> $ERROR_LOG_FILE >> $LOG_FILE &
            echo $! > $PID_PATH_NAME
            echo "$SERVICE_NAME started"
        else
            echo "$SERVICE_NAME is already running"
        fi
    ;;
    stop)
        if [ -f $PID_PATH_NAME ]; then
            PID=$(cat $PID_PATH_NAME);
            echo "$SERVICE_NAME stopping ..."
            kill $PID;
            echo "$SERVICE_NAME stopped"
            rm $PID_PATH_NAME
        else
            echo "$SERVICE_NAME is not running ..."
        fi
    ;;
    restart)
        if [ -f $PID_PATH_NAME ]; then
            PID=$(cat $PID_PATH_NAME);
            echo "$SERVICE_NAME stopping ...";
            kill $PID;
            echo "$SERVICE_NAME stopped";
            rm $PID_PATH_NAME
            echo "$SERVICE_NAME starting ..."
            nohup java -jar $PATH_TO_JAR /tmp 2>> $ERROR_LOG_FILE >> $LOG_FILE &
            echo $! > $PID_PATH_NAME
            echo "$SERVICE_NAME started"
        else
            echo "$SERVICE_NAME is not running ..."
        fi
    ;;
esac