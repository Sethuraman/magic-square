#!/bin/sh
if [ "$#" -ne 1 ]; then
    echo "Usage: sh /go.sh <order of magic square>"
    exit 1
fi
./gradlew run -PappArgs=$1