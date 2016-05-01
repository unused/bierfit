require 'rails_helper'

describe Beer do
  context 'validations' do
    subject { build(:beer) }
    it { should belong_to(:user).dependent(:destroy) }
    it { should validate_inclusion_of(:state).in_array(%w(0.33 0.5 1.0)) }
    it { should have_many(:gulps) }
  end
end
