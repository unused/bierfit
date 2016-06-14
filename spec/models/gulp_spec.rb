require 'rails_helper'

describe Gulp do
  context 'validations' do
    it { should validate_presence_of(:beer) }
    it { should validate_presence_of(:amount_in_ml) }
    it { should validate_presence_of(:consumed_at) }
  end
end
