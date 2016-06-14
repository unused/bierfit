class CreateDevices < ActiveRecord::Migration
  def change
    create_table :devices do |t|
      t.string :label
      t.string :api_key

      t.timestamps null: false
    end
  end
end
