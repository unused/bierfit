
# Bierfit

A fitnees tracker for drinking beer that automatically tracks speed, amount and present some awesome statistics.

[![Build Status](https://travis-ci.org/unused/bierfit.svg?branch=master)](https://travis-ci.org/unused/bierfit)

## Development

### Testing

Test heavily use [rspec](https://relishapp.com/rspec/) with [browser DSL capybara](https://github.com/jnicklas/capybara#using-capybara-with-rspec) and [short form helpers shoulda-matchers](https://github.com/thoughtbot/shoulda-matchers), as well as [factory girl](https://github.com/thoughtbot/factory_girl/blob/master/GETTING_STARTED.md) to create test data.

### Webservice Development

In dev/ you find a debugging webservice you can use to see incoming messages. Do `$ cd dev/`, `$ bundle install` and run with `$ ./webservice_logger`.

The transport service reading data from arduino and sending events to the main webservice can be found in raspberry/.

