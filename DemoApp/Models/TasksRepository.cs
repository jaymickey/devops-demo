using System.Collections.Generic;
using System.Data.Entity;
using System.Threading.Tasks;

namespace DemoApp.Models
{
    public class TasksRepository : ITasksRepository
    {
        private readonly TaskDbContext _db = new TaskDbContext();

        public Task<List<TaskItem>> ListAsync()
        {
            return _db.Tasks.ToListAsync();
        }

        public Task AddAsync(TaskItem task)
        {
            _db.Tasks.Add(task);
            return _db.SaveChangesAsync();
        }

        public Task UpdateAsync(TaskItem task)
        {
            _db.Entry(task).State = EntityState.Modified;
            return _db.SaveChangesAsync();
        }

        public Task DeleteAsync(TaskItem task)
        {
            _db.Tasks.Remove(task);
            return _db.SaveChangesAsync();
        }
    }
}