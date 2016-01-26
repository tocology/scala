# Scala

This repository for writing and testing scala code.

## Development

### Preperation

For making scala project by sbt, we should download 'jar' file and set enviroment.
```console
> wget https://storage.googleapis.com/google-code-archive-downloads/v2/code.google.com/simple-build-tool/sbt-launch-0.7.7.jar
> java -Xmx512M -jar sbt-launch-0.7.7.jar "$@"
```

When hitting this command, we can see following suggestion that we are able to create new project if we don't have one.

> Note : Project name and Organization name are required essentially (not default).

```console
Project does not exist, create new project? (y/N/s) y
```