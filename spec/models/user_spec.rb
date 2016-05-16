require 'rails_helper'

describe User do
  context 'validations' do
    subject { build(:user) }
    it { should validate_presence_of(:username) }
    it { should validate_presence_of(:email) }
    it { should validate_uniqueness_of(:username), case_insensitive: true }
  end

  it "should display a user is \"online\"" do
    expect(build(:user).drinking?).to be false
    user = create(:consume_event, consumed_at: 1.minute.ago).user
    expect(user.drinking?).to be true
  end
end
