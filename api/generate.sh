#openapi-generator generate -i ./public.openapi.yaml -g spring -o gen/ --additional-properties=apiPackage=pm.little.api.controllers,basePackage=pm.little.api,configPackage=pm.little.api.confs,modelPackage=pm.little.api.models

#client
openapi-generator generate -i ./public.openapi.yaml -g java -o gen/ --additional-properties=modelPackage=pm.little.client.project.models,invokerPackage=pm.little.client.project.invokers,apiPackage=pm.little.client.project.defaultapi

