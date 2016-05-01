class CreateBeers < ActiveRecord::Migration
  def change
    create_table :beers do |t|
      t.integer :amount_in_ml
      t.datetime :finished_at
      t.integer :size

      t.timestamps null: false
    end
  end
end
