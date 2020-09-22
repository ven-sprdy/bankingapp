```
brew install mysql
```
```
brew services start mysql
brew services stop mysql
```
```
brew tap mongodb/brew
brew install mongodb-community
```
```
brew services start mongodb-community
brew services stop mongodb-community
```
```
Intellij VM options -Dspring.profiles.active=dev -Djasypt.encryptor.password=
```
```
Run below commands for production build jar file
mvn clean package -Dspring.profiles.active=dev
ls target/
jar tvf target/bankingapp-0.0.1-SNAPSHOT.jar 
SERVER_PORT=8000 java -jar target/bankingapp-0.0.1-SNAPSHOT.jar
```
```
Run below command with active profiles
java -jar target/bankingapp-0.0.1-SNAPSHOT.jar --spring.profiles.active=dev
```