#!/bin/bash

function main {
	echo "[LIFERAY] To SSH into this container, run: \"docker exec -it ${HOSTNAME} /bin/bash\"."
	echo ""

    echo "Update database config file"
    # update database config file
    sed -i "s/DATABASE_HOST/$DATABASE_HOST/g" ${LIFERAY_HOME}/portal-ext.properties
    sed -i "s/DATABASE_NAME/$DATABASE_NAME/g" ${LIFERAY_HOME}/portal-ext.properties
    sed -i "s/DATABASE_USERNAME/$DATABASE_USERNAME/g" ${LIFERAY_HOME}/portal-ext.properties
    sed -i "s/DATABASE_PASSWORD/$DATABASE_PASSWORD/g" ${LIFERAY_HOME}/portal-ext.properties

    echo "/etc/liferay/files folder contents"
    ls -al /etc/liferay/files
    echo "/etc/liferay/deploy folder contents"
	ls -al /etc/liferay/deploy

	echo ""
	echo "[LIFERAY] Starting ${LIFERAY_PRODUCT_NAME}. To stop the container with CTRL-C, run this container with the option \"-it\"."
	echo ""

	${LIFERAY_HOME}/tomcat/bin/catalina.sh run
}

main