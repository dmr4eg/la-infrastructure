#spring
#openapi-generator generate -i ./public.openapi.yaml -g spring -o gen/spring/ --additional-properties=apiPackage=pm.little.api.controllers,basePackage=pm.little.api,configPackage=pm.little.api.confs,modelPackage=pm.little.api.models

#java-client
#openapi-generator generate -i ./public.openapi.yaml -g java -o gen/ --additional-properties=modelPackage=pm.little.client.project.models,invokerPackage=pm.little.client.project.invokers,apiPackage=pm.little.client.project.defaultapi

#fe-js
openapi-generator generate -i ./public.openapi.yaml -g javascript -o gen/js/ --additional-properties=apiPackage=controllers,invokerPackage=openapi,modelPackage=models