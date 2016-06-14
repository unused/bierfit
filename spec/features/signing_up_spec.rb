require 'rails_helper'

RSpec.feature "Guest user can sign up", type: :feature do
  scenario "providing valid details" do
    user     = build(:user)
    password = String(Faker::Internet.password)

    login_as nil

    visit "/"
    click_link "Sign up"
    fill_in "Username", with: user.username
    fill_in "Email", with: user.email
    fill_in "user_password", with: password
    fill_in "Password confirmation", with: password
    click_button "Sign up"
    expect(page).to have_content "Welcome, grab a beer!"
  end
end
