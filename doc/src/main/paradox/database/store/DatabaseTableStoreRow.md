<!-- Generated File -->
# store

## Columns

| Name                         | Type               | NotNull| Unique | Indexed  | Default
|------------------------------|--------------------|--------|--------|----------|--------------------
| store_id                     | integer            | true   | true   | true     | nextval('store_store_id_seq'::regclass)
| manager_staff_id             | integer            | true   | true   | true     |
| address_id                   | integer            | true   | false  | true     |
| last_update                  | timestamptz        | true   | false  | true     | now()

## References

| Name                         | Target             | Table                                  | Column
|------------------------------|--------------------|----------------------------------------|--------------------
| customerStoreIdFkey          | store_id           | [customer](DatabaseTableCustomerRow)   | store_id
| inventoryStoreIdFkey         | store_id           | [inventory](DatabaseTableInventoryRow) | store_id
| staffStoreIdFkey             | store_id           | [staff](DatabaseTableStaffRow)         | store_id
