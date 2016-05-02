require 'rails_helper'

RSpec.describe UsersController, type: :controller do
  before(:all) do
    login_as create(:user), scope: :user
  end

  # TODO show only public user or self
  # TODO use slug [:username] instead of :id
  # TODO allow guest access but show join

  describe "GET show" do
    it "assigns @users" do
      user = create(:user)
      get :show, id: user.id
      expect(assigns(:user)).to eq(user)
    end
  end
end
