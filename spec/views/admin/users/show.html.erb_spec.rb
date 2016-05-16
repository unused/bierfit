require 'rails_helper'

RSpec.describe "admin/users/show", type: :view do
  before(:each) do
    @user = create(:user)
  end

  it "renders attributes in <p>" do
    render
  end
end
