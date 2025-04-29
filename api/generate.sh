#spring-content
#openapi-generator generate -i ./public.content.openapi.yaml -g spring -o gen/spring/content --additional-properties=apiPackage=pm.little.api.controllers,basePackage=pm.little.api,configPackage=pm.little.api.confs,modelPackage=pm.little.api.models

#spring-course
#openapi-generator generate -i ./public.course.openapi.yaml -g spring -o gen/spring/course --additional-properties=apiPackage=pm.little.api.controllers,basePackage=pm.little.api,configPackage=pm.little.api.confs,modelPackage=pm.little.api.models

#fe-js-content
openapi-generator generate \
    -i ./content.openapi.yaml \
    -g typescript-fetch \
    -o gen/ts/api-content \
    --additional-properties=apiPackage=controllers,invokerPackage=api-content,modelPackage=models

#fe-js-course
openapi-generator generate \
    -i ./course.openapi.yaml \
    -g typescript-fetch \
    -o gen/ts/api-course \
    --additional-properties=apiPackage=controllers,invokerPackage=api-course,modelPackage=models