class AddProcessedToConsumeEvent < ActiveRecord::Migration
  def change
    add_column :consume_events, :processed, :boolean
  end
end
