#!/usr/bin/env bash

# create and start stagging stack
stagging_up(){
    docker-compose -f docker-compose.yml up -d mariadb
    docker image prune -f # remove immediate images used when build database container
    sleep 20
    docker-compose -f docker-compose.yml up -d opencpsv2-portal
}

# stop and clear stagging stack
stagging_down(){
    docker-compose -f docker-compose.yml down -v --rmi local
}

COMMAND=$1

case "$COMMAND" in
 stagging-up) stagging_up ;;
 stagging-down) stagging_down ;;
esac