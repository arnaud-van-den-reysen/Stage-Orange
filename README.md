# Projet Gestion de formulaire personnalisable

## Fonctionnement de l'API
* Installer Java 8 et Maven
* Compiler et lancer les tests
```console
mvn clean package
```
* Lancer le serveur local
```console
mvn tomcat7:run
```
### API Restful
* Base URL
```http://localhost:9090/api/```
* DataFormulaire
    * ```GET /dataFormulaire```
    * ```GET /dataFormulaire/:id```
    * ```GET /dataFormulaire/formulaire/:id```
    * ```POST /dataFormulaire```
    * ```PUT /dataFormulaire/:id```
    * ```DELETE /dataFormulaire/:id```
* Formulaire
    * ```GET /produits```
    * ```GET /produits/:id```
    * ```POST /produits```
    * ```PUT /produits/:id```
    * ```DELETE /produits/:id```
* product_json (Test_json)
    * ```GET /test_json```
    * ```GET /test_json/test_json/:id```
    * ```POST /test_json/test_json```
    * ```PUT /test_json/test_json```
    * ```DELETE /test_json/test_json/:id```
* Resource
    * ```GET /myresource```
* Produits
    * ```GET /v1/produits```
    * ```GET /v1/produits/produit/:idprod```
    * ```POST /v1/produits/produit```
    * ```PUT /v1/produits/produit```
    * ```DELETE /v1/produits/produit/:idprod```

### Example cURL
* /GET
```console
user@dir:~$ curl http://localhost:9090/api/test_json
```
* /GET/{id}
```console
user@dir:~$ curl http://localhost:9090/api/test_json/test_json/4
```
* /POST
```console
user@dir:~$ curl -v -X POST -H "Content-Type: application/json" -d '{"idprod": 1, "nameprod": "Transfert de fichier", "description": "test de transfert de fichier produit"}' http://localhost:9090/api/test_json/test_json
```
* /DELETE/{id}
```console
user@dir:~$ curl -X DELETE http://localhost:9090/api/test_json/test_json/16
```

### Tests
* Hibernate
    * save()
    * update()
    * find()
    * createQuery("from TABLE",...)
    * delete()
* DataFormulaire
    * getDataFormulaires()
    * getDataFormulaire(1)

## Fonctionnement du Front Angular
* Installer Angular 12
* Lancer Angular
```console
ng serve --open
```
### Tests
* Formulaire
    * GET /produits/1
    * POST /produits
    * PUT /produits/1
    * DELETE /produits/1
* product_json (Test_json)
    * GET /test_json/test_json/4
    * POST /test_json/test_json
    * PUT /test_json/test_json
    * DELETE /test_json/test_json/8