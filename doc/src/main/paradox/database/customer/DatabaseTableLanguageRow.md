<!-- Generated File -->
# language

## Columns

| Name                         | Type               | NotNull| Unique | Indexed  | Default
|------------------------------|--------------------|--------|--------|----------|--------------------
| language_id                  | integer            | true   | true   | true     | nextval('language_language_id_seq'::regclass)
| name                         | string             | true   | false  | true     |
| last_update                  | timestamptz        | true   | false  | true     | now()

## References

| Name                         | Target             | Table                                  | Column
|------------------------------|--------------------|----------------------------------------|--------------------
| filmLanguageIdFkey           | language_id        | [film](DatabaseTableFilmRow)           | language_id
| filmOriginalLanguageIdFkey   | language_id        | [film](DatabaseTableFilmRow)           | original_language_id
