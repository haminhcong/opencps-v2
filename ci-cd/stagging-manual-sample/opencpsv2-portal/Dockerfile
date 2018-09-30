FROM liferay/portal:7.1.0-ga1-201809012030

USER root
COPY .bashrc /etc/liferay/
COPY entrypoint.sh /etc/liferay/
RUN ["chmod", "+x", "/etc/liferay/entrypoint.sh"]

RUN chown liferay:liferay /opt/liferay
RUN chown liferay:liferay /etc/liferay

USER liferay:liferay

ENTRYPOINT /etc/liferay/entrypoint.sh
WORKDIR /opt/liferay
