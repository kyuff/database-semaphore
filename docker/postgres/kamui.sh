# http://learningdocker.com/running-postgresql-service-docker-container/
docker run -p ::5432 \
	--name db \
	--rm \
	-e POSTGRESQL_DB=docker \
	-e POSTGRESQL_USER=docker \
	-e POSTGRESQL_PASS=docker \
		kamui/postgresql
