require 'rails_helper'

describe Device do
  context 'validations' do
    it { should validate_presence_of(:label) }
    it { should validate_presence_of(:owner) }
    it { should validate_uniqueness_of(:api_key) }
  end
end
