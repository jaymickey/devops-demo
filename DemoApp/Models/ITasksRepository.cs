using System.Collections.Generic;
using System.Threading.Tasks;

namespace DemoApp.Models
{
    public interface ITasksRepository
    {
        Task<List<TaskItem>> ListAsync();
        void Add(TaskItem task);
        Task UpdateAsync(TaskItem task);
        Task DeleteAsync(TaskItem task);
    }
}