class AddOwnerToDevice < ActiveRecord::Migration
  def change
    add_column :devices, :owner_id, :integer, index: true, foreign_key: true
  end
end
