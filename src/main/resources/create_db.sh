cat user_schema_tables_init | docker exec -i $1 psql -U $2 -d $3