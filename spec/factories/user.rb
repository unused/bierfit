
FactoryGirl.define do
  factory :user, aliases: [:owner] do
    name     { Faker::Name.name }
    username { Faker::Internet.user_name }
    email    { Faker::Internet.email }
    password { Faker::Internet.password }

    # NOTE public is a reserved word so we have to use add_attribute
    add_attribute(:public) { [true, false].sample }

    admin    { false }

    factory :admin do
      admin { true }
    end
  end
end
