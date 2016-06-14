require 'rails_helper'

RSpec.describe UsersController, type: :controller do

  describe "user profile" do
    it "is displayed to guests if public" do
      user = create(:user, public: true)

      get :show, slug: user

      expect(response).to have_http_status(:success)
    end

    it "is hidden to guests if private" do
      user = create(:user, public: false)

      get :show, slug: user

      expect(response).to redirect_to(root_path)
    end

    it "is hidden to guests if private" do
      user = create(:user, public: false)
      get :show, slug: user.username

      expect(response).to redirect_to(root_path)
    end

    it "is displayed to myself" do
      user = create(:user, public: false)
      sign_in user

      get :show, slug: user.username

      expect(response).to have_http_status(:success)
    end
  end

  describe "user update" do
    it "allows to change my name" do
      user = create(:user)
      name = String(Faker::Name.name)
      sign_in user

      put :update, slug: user.id, user: { name: name }

      user.reload
      expect(user.name).to eq(name)
    end

    it "disallows to change my email or username" do
      user     = create(:user, public: false)
      email    = String(Faker::Internet.email)
      username = String(Faker::Internet.user_name)
      sign_in user

      post :update, slug: user.username,
        user: { username: username, email: email }

      user.reload
      expect(user.email).to eq(user.email)
      expect(user.username).to eq(user.username)
    end
  end
end
