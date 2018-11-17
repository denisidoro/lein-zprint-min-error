(defproject journal "0.0.1-SNAPSHOT"
  :description
    "Very simplistic example of how I organize and test microservices"
  :url "https://github.com/denisidoro/journal"
  :license {:name "Apache License, Version 2.0"}
  :plugins [[lein-tools-deps "0.4.1"]
            [lein-midje "3.2.1"]
            [lein-zprint "0.3.12"]
            [lein-cljfmt "0.6.1"]]
  :middleware [lein-tools-deps.plugin/resolve-dependencies-with-deps-edn]
  :zprint {:old? false}
  :lein-tools-deps/config {:config-files
                             [:install :user :project "deps/main.edn"]}
  :min-lein-version "2.0.0"
  :resource-paths ["config" "resources"]
  :profiles {:dev {:aliases
                     {"run-dev"
                        ["trampoline" "run" "-m" "journal.server/run-dev"]},
                   :lein-tools-deps/config {:config-files ["deps/dev.edn"]}},
             :uberjar {:aot [journal.server]}}
  :main ^{:skip-aot true} journal.server)
