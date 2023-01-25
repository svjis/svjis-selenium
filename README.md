# Selenium testy pro SVJIS

[![build](https://github.com/svjis/svjis-selenium/actions/workflows/maven.yml/badge.svg)](https://github.com/svjis/svjis-selenium/actions/workflows/maven.yml)

## Jak spustit testy

1. Ujistěte se, že aplikace SVJIS běží na adrese http://localhost:8080. Spustit jí můžete například pomocí [docker-compose](https://github.com/svjis/svjis-docker/tree/master/docker-compose).


1. Zjistěte jakou verzi prohližeče Chrome máte nainstalovanou na vašem počítači a stáhněte odpovídající verzi [chromedriveru](https://chromedriver.chromium.org/downloads). Tu nakopírujte do `src/test/resources/drivers/`.


Nyní můžete test spustit:

```
mvn test
```

Parametrizace testu je v souboru [constants.properties](src/main/resources/constants.properties).
