source 'https://rubygems.org'

# Bundle edge Rails instead: gem 'rails', github: 'rails/rails'
gem 'rails', '4.2.4'
# Use SCSS for stylesheets
gem 'sass-rails', '~> 5.0'
# Use Uglifier as compressor for JavaScript assets
gem 'uglifier', '>= 1.3.0'
# Use CoffeeScript for .coffee assets and views
gem 'coffee-rails', '~> 4.1.0'
# See https://github.com/rails/execjs#readme for more supported runtimes
# gem 'therubyracer', platforms: :ruby

# Use jquery as the JavaScript library
gem 'jquery-rails'
# Turbolinks makes following links in your web application faster. Read more: https://github.com/rails/turbolinks
gem 'turbolinks'
# Build JSON APIs with ease. Read more: https://github.com/rails/jbuilder
gem 'jbuilder', '~> 2.0'
# bundle exec rake doc:rails generates the API under doc/api.
gem 'sdoc', '~> 0.4.0', group: :doc

# Use ActiveModel has_secure_password
# gem 'bcrypt', '~> 3.1.7'

# Use Unicorn as the app server
# gem 'unicorn'

# Use Capistrano for deployment
# gem 'capistrano-rails', group: :development

# User drink Bier
gem 'devise', '~> 4.0.1'

# Add some style
gem 'bootstrap-sass'
# Style forms
gem 'simple_form', '~> 3.2.1'
# Pagination
gem 'will_paginate', '~> 3.0.7'

group :development, :test do
  # Call 'byebug' anywhere in the code to stop execution and get a debugger
  #   console
  gem 'byebug'
  # Use sqlite3 as the database for Active Record
  gem 'sqlite3'

  # Fixtures Generator
  gem 'factory_girl_rails', '~> 4.7.0', require: false
  # Nice Behaviour Tests
  gem 'rspec-rails', '~> 3.4.2'
  # Fake Data Generator
  gem 'faker', '~> 1.6.3'
  # Ensure people code ruby
  gem 'rubocop', '~> 0.39.0', require: false
end

group :test do
  # Rails helpers, test one-liners
  gem 'shoulda-matchers', '~> 3.1.1'
  # Acceptance test framework
  gem 'capybara', '~> 2.6.2'
end

group :development do
  # Access an IRB console on exception pages or by using <%= console %> in views
  gem 'web-console', '~> 2.0'

  # Spring speeds up development by keeping your application running in the
  #   background. Read more: https://github.com/rails/spring
  gem 'spring'
end

group :production do
  # Use postgres for now as production db
  gem 'pg'
end
