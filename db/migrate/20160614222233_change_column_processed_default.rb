class ChangeColumnProcessedDefault < ActiveRecord::Migration
  def change
    change_column :consume_events, :processed, :boolean, null: false, default: false
  end
end
