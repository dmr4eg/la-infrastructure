#spring-content
openapi-generator generate -i ./public.content.openapi.yaml -g spring -o gen/spring/content --additional-properties=apiPackage=pm.little.api.controllers,basePackage=pm.little.api,configPackage=pm.little.api.confs,modelPackage=pm.little.api.models

#spring-course
openapi-generator generate -i ./public.course.openapi.yaml -g spring -o gen/spring/course --additional-properties=apiPackage=pm.little.api.controllers,basePackage=pm.little.api,configPackage=pm.little.api.confs,modelPackage=pm.little.api.models

#fe-js
#openapi-generator generate -i ./public.openapi.yaml -g javascript -o gen/js/ --additional-properties=apiPackage=controllers,invokerPackage=openapi,modelPackage=models