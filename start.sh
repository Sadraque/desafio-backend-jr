mvn package -DskipTests;

docker build -t desafio-backend-jr . ;

docker-compose up --force-recreate --build --remove-orphans