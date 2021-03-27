# Selenium testy pro SVJIS

## Jak spustit testy

Ujistěte se, že aplikace SVJIS běží na adrese http://localhost:8080. Spustit jí můžete například pomocí [docker-compose](https://github.com/svjis/svjis-docker/tree/master/docker-compose) - proveďte spuštění aplikace a vytvoření schematu databáze.


Zjistěte jakou verzi prohližeče Chrome máte nainstalovanou na vašem počítači a stáhněte odpovídající verzi [chromedriveru](https://chromedriver.chromium.org/downloads). Tu nakopírujte do `src/test/resources/drivers/`.


Nyní můžete test zkompilovat:

```
mvn clean install
```

a spustit:
```
java -jar target/svjis-selenium-1.0.0-SNAPSHOT.jar
```
