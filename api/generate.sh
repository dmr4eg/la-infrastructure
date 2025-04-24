#spring-content
#openapi-generator generate -i ./public.content.openapi.yaml -g spring -o gen/spring/content --additional-properties=apiPackage=pm.little.api.controllers,basePackage=pm.little.api,configPackage=pm.little.api.confs,modelPackage=pm.little.api.models

#spring-course
#openapi-generator generate -i ./public.course.openapi.yaml -g spring -o gen/spring/course --additional-properties=apiPackage=pm.little.api.controllers,basePackage=pm.little.api,configPackage=pm.little.api.confs,modelPackage=pm.little.api.models

#fe-js-content
openapi-generator generate -i ./public.content.openapi.yaml -g javascript -o gen/js/content --additional-properties=apiPackage=controllers,invokerPackage=api-content-service,modelPackage=models

#fe-js-course
openapi-generator generate -i ./public.course.openapi.yaml -g javascript -o gen/js/course --additional-properties=apiPackage=controllers,invokerPackage=api-course-service,modelPackage=models