require 'rails_helper'

RSpec.describe UsersController, type: :controller do
  describe "GET index" do
    it "assigns @users" do
      get :index
      expect(assigns(:users)).to eq([User.all])
    end

    it "renders the index template" do
      get :index
      expect(response).to render_template("index")
    end
  end
end
