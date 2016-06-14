require 'securerandom'

FactoryGirl.define do
  factory :device do
    # just a descriptive label
    label   { %w(MeiDeckel MeiDeckel2 MeiDeckelPro).sample }
    api_key { SecureRandom.urlsafe_base64 }
    owner
    users
  end
end
