# Bierfit

A fitnees tracker for drinking beer that automatically tracks speed, amount and present some awesome statistics.

[![Build Status](https://travis-ci.org/unused/bierfit.svg?branch=master)](https://travis-ci.org/unused/bierfit)

<a title="Realtime application protection" href="https://www.sqreen.io/?utm_source=badge"><img style="width:109px;height:36px" src="https://s3-eu-west-1.amazonaws.com/sqreen-assets/badges/20161213/sqreen-badgeDark@2x.png" alt="Sqreen | Runtime Application Protection" /></a>

## Development

### Github Page

The [github-page](http://unused.github.io/bierfit) is located in [gh-pages directory](/gh-pages/).

```sh
$ git subtree push --prefix gh-pages origin gh-pages # update github.io page
```

### Use a docker postgres database server

```
$ docker run --name bierfit-postgres -d postgres
```
