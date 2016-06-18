class AddDurationInSecondsToGulps < ActiveRecord::Migration
  def change
    add_column :gulps, :duration_in_seconds, :integer
  end
end
