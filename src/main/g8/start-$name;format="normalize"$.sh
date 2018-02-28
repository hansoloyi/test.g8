#!/bin/bash

set -o nounset
set -e

function usage(){
        cat <<EOF
Batch load data to Druid
ARGS:
        1) command line args to pass into the Java class


EOF
        exit 1
}

function unknown(){
        cat <<EOF
UNKNOWN option
EOF
}

###############################
#### MAIN
###############################
CORES=40


WORKING_DIR=/home/spark/$name;format="normalize"$
ASSEMBLY="\$WORKING_DIR/$name;format="normalize"$-assembly.jar"
CONF=\$WORKING_DIR/application.conf

echo "LAUNCHING $name$ with args \$@"

jar uf \$(readlink -f \$ASSEMBLY) -C \$WORKING_DIR \$(basename \$CONF) && \\

set -x
/usr/bin/java \\
-cp /opt/spark/conf/:/opt/spark/jars/*:/etc/hive/conf/ \\
-Dconfig.file=\$CONF \\
org.apache.spark.deploy.SparkSubmit \\
  --class $package$.$name;format="Camel"$App \\
  --total-executor-cores \$CORES \\
  --conf spark.eventLog.enabled=false \\
  --conf spark.ui.showConsoleProgress=false \\
  --conf spark.sql.tungsten.enabled=true \\
  --conf spark.executor.cores=5 \\
  --conf spark.memory.offHeap.enabled=true \\
  --conf spark.memory.offHeap.size=5g \\
  --driver-memory 10g \\
  --executor-memory 15g \\
   \$ASSEMBLY "\$@"
