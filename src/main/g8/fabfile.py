#!/usr/bin/env python2.7

from fabric.api import env, hosts, put, sudo
from fabric.context_managers import settings

env.use_ssh_config = True

env.hosts = ['airflow-linear.prod.dc3']

with open('version.sbt', 'r') as versionFile:
    version = versionFile.read().replace('\n', '').rsplit(':=')[1].strip().strip('"')

jar_filename = "$name;format="normalize"$-core-assembly-{0}.jar".format(version)
ln_jar_filename = "$name;format="normalize"$-core-assembly.jar"
app_path = "$name;format="normalize"$-core"


def deploy():
    put("ingest/target/scala-2.11/{0}".format(jar_filename), "~/")
    sudo("mv {0} /home/spark/{1}/".format(jar_filename, app_path))
    sudo("chown spark:spark /home/spark/{0}/{1}".format(app_path, jar_filename))
    sudo("ln -sf {0} /home/spark/{1}/{2}".format(jar_filename, app_path, ln_jar_filename))
