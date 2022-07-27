## How to build
Para compilar : sam build
Para tirar en el docker container
Correr el siguiente comando : sam local invoke PostHandlerLambdaFunction --event events/event.json


### Para debuguear
sam local invoke PostHandlerLambdaFunction --event events/event.json -d 5858
Y crear un Remote JVM Debug configuration.


### Para hacer deploy para primera vez:
sam deploy --guided

### Como borrar todo en AWS con el nombre que quedo en samconfig.toml
sam delete CocoApi


### Sam Logs

sam logs --name PostHandlerLambdaFunction --stack-name TravelAppAPI
### Online logs
sam logs --name PostHandlerLambdaFunction --stack-name TravelAppAPI --tail