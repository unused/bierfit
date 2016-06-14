require 'rails_helper'

RSpec.describe "admin/users/index", type: :view do
  before(:each) do
    2.times { create(:user) }
    assign(:users, User.paginate(page: 1))
  end

  it "renders a list of admin/users" do
    render
  end
end
