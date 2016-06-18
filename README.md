
# Bierfit

A fitnees tracker for drinking beer that automatically tracks speed, amount and present some awesome statistics.

[![Build Status](https://travis-ci.org/unused/bierfit.svg?branch=master)](https://travis-ci.org/unused/bierfit)

## Development

### Testing

Test heavily use [rspec](https://relishapp.com/rspec/) with [browser DSL capybara](https://github.com/jnicklas/capybara#using-capybara-with-rspec) and [short form helpers shoulda-matchers](https://github.com/thoughtbot/shoulda-matchers), as well as [factory girl](https://github.com/thoughtbot/factory_girl/blob/master/GETTING_STARTED.md) to create test data.

To ensure ruby style we use [rubocop](https://github.com/bbatsov/rubocop) that parses the source files to detect smells within syntax usage that does not go along with [the ruby community style guide](https://github.com/bbatsov/ruby-style-guide).

```sh
$ bundle exec rspec # run rspec tests
$ bundle exec rubocop # run rubocop check, use -F for fast-fail
$ bundle exec rake # run complete test suite
```

### Github Page

The [github-page](http://unused.github.io/bierfit) is located in [gh-pages directory](/gh-pages/).

```sh
$ git subtree push --prefix gh-pages origin gh-pages # update github.io page
```

## References

- [Background Image](/app/assets/images/background.jpg) from [Maciej Serafinowicz via unsplash.com](https://unsplash.com/photos/BC49M6wl--8).