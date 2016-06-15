require 'rails_helper'

RSpec.describe Beeralyzer do
  TEST_DATA = [0, 2, 3, 0, 325, 320, 0, 123, 125, 120, 0, 0, 450, 444].freeze

  def test_data
    TEST_DATA.each_with_index.map do |v, i|
      { value: v, date: Time.now + i.minutes }
    end
  end

  it "knows what's in the bottle" do
    beeralyzer = Beeralyzer.new(test_data)
    result = beeralyzer.bottle_states.map(&:value)
    expect(result).to eq [322, 122, 447]
  end

  it "knows where the beer has gone" do
    beeralyzer = Beeralyzer.new(test_data)
    result = beeralyzer.gulps.map(&:amount_in_ml)
    expect(result).to eq [200, -325]
  end

  it "knows the bill" do
    beeralyzer = Beeralyzer.new(test_data)
    expect(beeralyzer.extract.count).to eq 2
  end
end
