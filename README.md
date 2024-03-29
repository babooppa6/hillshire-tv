# hillshire-tv

Hillshire.TV is powered by The [Luminus][1] framework for Clojure.

[1]: http://www.luminusweb.net

## Prerequisites

You will need [Leiningen][2] 2.0 or above installed.

[2]: https://github.com/technomancy/leiningen

## Database

This project uses PostgreSQL by default.  To use another database, change the database information appropriately in "src/lobos/config.clj" and "src/hillshire_tv/db/core.clj".  Also be sure to change your database username/password in these files.

### Migrations

To migrate or rollback, fire up the REPL in the root directory of the project and use the (migrate) or (rollback) functions.  For example:

    lein repl

    user=> (require '[lobos.core :refer [migrate rollback]])
    nil
    user=> (migrate)
    add-pages-table
    nil


## Running

To start the server and install the dependencies, run:

    lein run

## Deployment

To quickly deploy this project, you can create a standalone executable.  In the root directory of the project, run

    lein uberjar

To deploy, run the JAR file created in the "target" directory.

    java -jar hillshire-tv.jar

To run on other platforms (Tomcat, NGINX, etc.) see the [Luminus Documention][3] for details.

[3]: http://www.luminusweb.net/docs/deployment.md

## License

WTFPL
