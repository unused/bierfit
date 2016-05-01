
FactoryGirl.define do
  factory :user, aliases: [:owner] do
    name     { Faker::Name.name }
    username { Faker::Internet.user_name }
    email    { Faker::Internet.email }
    password { Faker::Internet.password }
    admin    { false }

    factory :admin do
      admin { true }
    end
  end
end
